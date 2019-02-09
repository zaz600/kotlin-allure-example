import io.qameta.allure.Description
import io.qameta.allure.Feature
import io.qameta.allure.TmsLink
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

/**
 * Калькулятор, который будем тестировать
 */
class Calc {
    fun add(x: Int, y: Int) = x + y
    fun div(x: Int, y: Int): Int = x / y
}


@DisplayName("Проверка калькулятора")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestCalc {
    private val calc = Calc()

    @Test
    @DisplayName("Проверка сложения положительных чисел")
    @Description("Описание теста")
    @Feature("Сложение")
    fun testAdd() {
        assertThat(calc.add(1, 2)).isEqualTo(3)
    }

    @Test
    @DisplayName("Проверка сложения отрицательных чисел")
    @Feature("Сложение")
    fun testAddBothNegative() {
        assertThat(calc.add(-1, -2)).isEqualTo(-3)
    }

    @Test
    @DisplayName("Проверка деления положительных чисел")
    @Feature("Деление")
    fun testDivPositiveNumbers() {
        assertThat(calc.div(4, 2)).isEqualTo(2)
    }

    @Test
    @DisplayName("Проверка деления на ноль")
    @Feature("Деление")
    fun testDivZero() {
        assertThat(calc.div(5, 0))
    }

    @Test
    @DisplayName("Проверка деления на отрицательное число")
    @Feature("Деление")
    @TmsLink("123321")
    fun testDivNegative() {
        // тест падает
        assertThat(calc.div(7, -2)).isEqualTo(-3.5)
    }
}