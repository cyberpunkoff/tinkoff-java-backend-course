package edu.hw11.task3;

import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.jar.asm.Label;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.Opcodes;

public class FibonacciMethod implements Implementation {
    @Override
    @NotNull
    public ByteCodeAppender appender(@NotNull Target target) {
        final String owner = "Fibonacci";
        final String methodName = "fib";
        final String methodDescriptor = "(I)J";
        final int maxMethodOperandStackSize = 10;

        return (methodVisitor, context, methodDescription) -> {
            methodVisitor.visitVarInsn(Opcodes.ILOAD, 0);
            methodVisitor.visitInsn(Opcodes.ICONST_1);

            final Label ifStatement = new Label();

            methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGT, ifStatement); // если номер числа Фибоначчи больше единицы,
            methodVisitor.visitInsn(Opcodes.ICONST_1);                   // то переходим на (*), иначе вернуть единицу
            methodVisitor.visitInsn(Opcodes.I2L);                        // в виде long
            methodVisitor.visitInsn(Opcodes.LRETURN);

            methodVisitor.visitLabel(ifStatement); // (*)
            methodVisitor.visitVarInsn(Opcodes.ILOAD, 0);
            methodVisitor.visitInsn(Opcodes.ICONST_1); // считаем n - 1 число
            methodVisitor.visitInsn(Opcodes.ISUB); // делаем рекурсивный вызов
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, owner, methodName, methodDescriptor, false);

            methodVisitor.visitVarInsn(Opcodes.ILOAD, 0);
            methodVisitor.visitInsn(Opcodes.ICONST_2); // n - 2
            methodVisitor.visitInsn(Opcodes.ISUB);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, owner, methodName, methodDescriptor, false);

            methodVisitor.visitInsn(Opcodes.LADD);
            methodVisitor.visitInsn(Opcodes.LRETURN); // возвращаем сумму рекурсивно посчитанных чисел

            return new ByteCodeAppender.Size(maxMethodOperandStackSize, 1);
        };
    }

    @Override
    @NotNull
    public InstrumentedType prepare(@NotNull InstrumentedType instrumentedType) {
        return instrumentedType;
    }
}
