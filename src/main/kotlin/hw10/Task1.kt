package hw10

import java.time.LocalDateTime.now
import kotlin.math.max

fun main() {

    //task1
    val lambdaFunction: () -> Unit = { println("*") }

    fun function(N: Int, F: () -> Unit) = repeat(N) { F() }
    function(7, lambdaFunction)

    //task2
    fun MAIN_F(F: () -> Unit) {
        println(now())
        F()
        println(now())
    }
    MAIN_F(lambdaFunction)

    //task3
    fun knapsack(weights: IntArray, costs: IntArray, needed: Int): Int {
        val n = weights.size
        val dp = Array(needed + 1) { IntArray(n + 1) }
        for (j in 1..n) {
            for (w in 1..needed) {
                val el1 = dp[w][j - 1]

                if (weights[j - 1] <= w) {
                    val el2Cost = costs[j - 1]
                    val el2 = dp[w - weights[j - 1]][j - 1]

                    dp[w][j] = Math.max(el1, el2 + el2Cost)
                } else {
                    dp[w][j] = el1
                }
            }
        }
        return dp[needed][n]
    }

    fun knapsackLambda(weightsF: (Int) -> Int, weightsSizeF: () -> Int, costsF: (Int) -> Int, neededF: () -> Int): Int {
        val needed = neededF()
        val n = weightsSizeF()
        val dp = Array(needed + 1) { IntArray(n + 1) }
        for (j in 1..n) {
            for (w in 1..needed) {
                val el1 = dp[w][j - 1]

                if (weightsF(j - 1) <= w) {
                    val el2 = dp[w - weightsF(j - 1)][j - 1]
                    val el2Cost = costsF(j - 1)

                    dp[w][j] = max(el1, el2 + el2Cost)
                } else {
                    dp[w][j] = el1
                }
            }
        }
        return dp[needed][n]
    }

}

