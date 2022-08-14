plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    val agpVersion = "7.2.2"
    val kotlinVersion = "1.7.10"
    val asmVersion = "9.3"
    implementation("com.android.tools.build:gradle:$agpVersion") {
        exclude(group = "org.ow2.asm")
    }
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion") {
        exclude(group = "org.ow2.asm")
    }
    implementation("org.ow2.asm:asm:$asmVersion")
    implementation("org.ow2.asm:asm-commons:$asmVersion")
    implementation("org.ow2.asm:asm-util:$asmVersion")
}

gradlePlugin {
    plugins {
        register("LogPlugin") {
            id = "me.hjhl.gradle.plugin.log"
            implementationClass = "LogPlugin"
        }
    }
}