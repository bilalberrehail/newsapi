package com.example.instantsystemtest.business.datasources.mappers

interface Mapper<FROM, TO> {
    fun to(from: FROM): TO
}