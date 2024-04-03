import org.gradle.kotlin.dsl.`kotlin-dsl`

/*
* I have created another Module for the dependencies for modularity
* if we have another modules in the project their dependency are from this dependencies model
* and inside utilities Module i'm handling internet errors
* and show it before it happens in the app
*
* */

plugins {
    `kotlin-dsl`
}

repositories{
    mavenCentral()
}