import org.gradle.api.Plugin
import org.gradle.api.Project

class LogPlugin : Plugin<Project> {
    companion object {
        private const val TAG = "LogPlugin"
    }

    override fun apply(target: Project) {
        log("======== start apply ========")
        log("apply target: ${target.displayName}")
        log("========  end apply  ========")
    }

    private fun log(msg: String) {
        println("[$TAG]: $msg")
    }
}