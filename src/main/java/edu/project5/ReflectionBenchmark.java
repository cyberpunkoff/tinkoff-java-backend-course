package edu.project5;

import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

@State(Scope.Thread)
@SuppressWarnings({"UncommentedMain", "MagicNumber"})
public class ReflectionBenchmark {
    private Student student;
    private Method method;
    private Function<Student, String> lambda;
    private MethodHandle methodHandle;

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
            .include(ReflectionBenchmark.class.getSimpleName())
            .shouldFailOnError(true)
            .shouldDoGC(true)
            .mode(Mode.AverageTime)
            .timeUnit(TimeUnit.NANOSECONDS)
            .forks(1)
            .warmupForks(1)
            .warmupIterations(1)
            .warmupTime(TimeValue.seconds(5))
            .measurementIterations(1)
            .measurementTime(TimeValue.seconds(5))
            .resultFormat(ResultFormatType.CSV)
            .build();

        new Runner(options).run();
    }

    @Setup
    public void setup() throws Throwable {
        student = new Student("Alexander", "Biryukov");
        method = Student.class.getDeclaredMethod("name");

        MethodHandles.Lookup lookup = MethodHandles.lookup();
        methodHandle = lookup.unreflect(method);

        lambda = (Function<Student, String>) LambdaMetafactory.metafactory(
            lookup,
            "apply",
            MethodType.methodType(Function.class), //сигнатура фабрики лямбда-выражений
            MethodType.methodType(Object.class, Object.class), //сигнатура метода Consumer.accept после стирания типов
            methodHandle, //ссылка на метод с кодом лямбда-выражения
            methodHandle.type()
        ).getTarget().invokeExact();
    }

    @Benchmark
    public void directAccess(Blackhole bh) {
        String name = student.name();
        bh.consume(name);
    }

    @Benchmark
    public void reflection(Blackhole bh) throws InvocationTargetException, IllegalAccessException {
        // TODO
        Object name = method.invoke(student);
        bh.consume(name);
    }

    @Benchmark
    public void methodHandle(Blackhole bh) throws Throwable {
        Object name = methodHandle.invoke(student);
        bh.consume(name);
    }

    @Benchmark
    public void lambdaFactory(Blackhole bh) {
        Object name = lambda.apply(student);
        bh.consume(name);
    }
}
