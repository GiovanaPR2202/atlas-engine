plugins {
    id("java")
    id("application")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val lwjglVersion = "3.3.1"
val osName = System.getProperty("os.name").lowercase()
val lwjglNatives = when {
    osName.contains("windows") -> "natives-windows"
    osName.contains("mac") -> "natives-macos"
    osName.contains("linux") -> "natives-linux"
    else -> throw GradleException("Sistema operacional não suportado: $osName")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation("org.lwjgl:lwjgl:$lwjglVersion")
    implementation("org.lwjgl:lwjgl-glfw:$lwjglVersion")
    implementation("org.lwjgl:lwjgl-vulkan:$lwjglVersion")
    implementation("org.lwjgl:lwjgl-stb:$lwjglVersion")

    runtimeOnly("org.lwjgl:lwjgl:$lwjglVersion:$lwjglNatives")
    runtimeOnly("org.lwjgl:lwjgl-glfw:$lwjglVersion:$lwjglNatives")
    runtimeOnly("org.lwjgl:lwjgl-stb:$lwjglVersion:$lwjglNatives")

    // Tinylog
    implementation("org.tinylog:tinylog-api:2.6.2")
    implementation("org.tinylog:tinylog-impl:2.6.2")
    // JOML
    implementation("org.joml:joml:1.10.5")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("org.example.Main")
}
