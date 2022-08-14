package me.hjhl.gradle.plugin.log

import com.android.build.api.instrumentation.AsmClassVisitorFactory
import com.android.build.api.instrumentation.ClassContext
import com.android.build.api.instrumentation.ClassData
import com.android.build.api.instrumentation.InstrumentationParameters
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

abstract class LogTransform : AsmClassVisitorFactory<InstrumentationParameters.None> {
    override fun createClassVisitor(
        classContext: ClassContext,
        nextClassVisitor: ClassVisitor
    ): ClassVisitor {
        return object : ClassVisitor(Opcodes.ASM5, nextClassVisitor) {
            val className = classContext.currentClassData.className
            override fun visitMethod(
                access: Int,
                name: String?,
                descriptor: String?,
                signature: String?,
                exceptions: Array<out String>?
            ): MethodVisitor {
                val oldMethodVisitor =
                    super.visitMethod(access, name, descriptor, signature, exceptions)
                return LogMethodVisitor(className, oldMethodVisitor, access, name, descriptor)
            }
        }
    }

    override fun isInstrumentable(classData: ClassData): Boolean {
        return true
    }
}