package com.work.juiceapp

interface Repository {
    fun increment()
    fun isMax(): Boolean
    fun reset()
    class Base(
        private var currentTimesClicked: IntCache
    ) : Repository {

        override fun increment() {
            val currentTimes = currentTimesClicked.read()
            val new = currentTimes + 1
            currentTimesClicked.save(new)
        }

        override fun isMax(): Boolean {
            return currentTimesClicked.read() == 5
        }

        override fun reset() {
            currentTimesClicked.save(0)
        }
    }
}
