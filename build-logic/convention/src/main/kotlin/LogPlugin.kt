import com.android.build.api.instrumentation.FramesComputationMode
import com.android.build.api.instrumentation.InstrumentationScope
import com.android.build.api.variant.AndroidComponentsExtension
import me.hjhl.gradle.plugin.log.LogTransform
import org.gradle.api.Plugin
import org.gradle.api.Project

class LogPlugin : Plugin<Project> {
    companion object {
        private const val TAG = "LogPlugin"
    }

    override fun apply(target: Project) {
        log("======== start apply ========")
        log("apply target: ${target.displayName}")
        val androidComponentsExtension =
            target.extensions.getByType(AndroidComponentsExtension::class.java)
        androidComponentsExtension.onVariants { variant ->
            log("variant: ${variant.name}")
            variant.instrumentation.apply {
                transformClassesWith(LogTransform::class.java, InstrumentationScope.PROJECT) {}
                setAsmFramesComputationMode(FramesComputationMode.COMPUTE_FRAMES_FOR_INSTRUMENTED_METHODS)
            }
        }
        log("========  end apply  ========")
    }

    private fun log(msg: String) {
        println("[$TAG]: $msg")
    }
}