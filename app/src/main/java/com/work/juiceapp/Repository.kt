package com.work.juiceapp

interface Repository {
    fun increment()
    fun isMax(): Boolean
    fun reset()
    class Base : Repository {

        private var currentTimesClicked = 0

        override fun increment() {
            currentTimesClicked++
        }

        override fun isMax(): Boolean {
            return currentTimesClicked == 5
        }

        override fun reset() {
            currentTimesClicked = 0
        }
    }
}
