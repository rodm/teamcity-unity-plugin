
plugins {
    id ("io.github.rodm.teamcity-base")
}

val teamcityVersion by extra((project.findProperty("teamcityVersion") ?: "2022.10") as String)

teamcity {
    version = teamcityVersion
}
