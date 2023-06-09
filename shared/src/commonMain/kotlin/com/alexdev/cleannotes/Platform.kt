package com.alexdev.cleannotes

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform