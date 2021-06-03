package br.com.systemsgs.forumalura.mapper

interface Mapper<T, U> {

    fun map(t: T): U

}