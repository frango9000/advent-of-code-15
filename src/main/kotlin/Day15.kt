fun main() {
    val input = readInput("Day15")
    Day15.part1(input).println()
    Day15.part2(input).println()
}

class Day15 {
    companion object {
        fun part1(input: List<String>): Int {
            val ingredients = input.map { it.getNumbers() }.map { Ingredient(it[0], it[1], it[2], it[3], it[4]) }
            return ingredients.getBestQuality(IntArray(ingredients.size), 0, 0)

        }

        fun part2(input: List<String>): Int {
            val ingredients = input.map { it.getNumbers() }.map { Ingredient(it[0], it[1], it[2], it[3], it[4]) }
            return ingredients.getBestQuality(IntArray(ingredients.size), 0, 0, 500)
        }
    }
}


private class Ingredient(
    val capacity: Int, val durability: Int, val flavor: Int, val texture: Int, val calories: Int
)

private fun List<Ingredient>.getBestQuality(
    ingredientAmounts: IntArray, count: Int, sum: Int, targetCalories: Int = 0
): Int {
    var best: Int = 0
    if (count == ingredientAmounts.size) {
        if (sum == 100) {
            val calories = this.indices.sumOf { ingredientAmounts[it] * this[it].calories }
            return if (targetCalories <= 0 || calories == targetCalories) {
                val capacity = this.indices.sumOf { ingredientAmounts[it] * this[it].capacity }.coerceAtLeast(0)
                val durability = this.indices.sumOf { ingredientAmounts[it] * this[it].durability }.coerceAtLeast(0)
                val flavor = this.indices.sumOf { ingredientAmounts[it] * this[it].flavor }.coerceAtLeast(0)
                val texture = this.indices.sumOf { ingredientAmounts[it] * this[it].texture }.coerceAtLeast(0)
                capacity * durability * flavor * texture
            } else 0
        }
    } else {
        for (i in 0..(100 - sum)) {
            ingredientAmounts[count] = i
            best = best.coerceAtLeast(getBestQuality(ingredientAmounts, count + 1, sum + i, targetCalories))
        }
    }
    return best
}
