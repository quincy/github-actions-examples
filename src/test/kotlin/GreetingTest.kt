import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class GreetingTest {

    private val greeters = setOf(FormalGreeter(), InformalGreeter(), FamiliarGreeter())

    @ParameterizedTest
    @ValueSource(
        strings = [
            "Alice",
            "Bob",
            "Charlie",
            "Diane",
            "Edward",
            "Fiona",
        ]
    )
    internal fun `greets people with familiar greeting`(name: String) {
        assertThat(greetPerson(greeters, name), equalTo("How you doin', $name?"))
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "Gregg",
            "Howard",
            "Iona",
            "Julia",
            "Kimberly",
            "Lancelot",
            "Marcus",
            "Nancee",
            "Oliver",
            "Prescott",
            "Quincy",
            "Ramona",
            "Silas",
        ]
    )
    internal fun `greets people with informal greeting`(name: String) {
        assertThat(greetPerson(greeters, name), equalTo("Howdy, $name!"))
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "Tess",
            "Ulrich",
            "Veronica",
            "Westley",
            "Xavier",
            "Yasmine",
            "Zelda",
        ]
    )
    internal fun `greets people with formal greeting`(name: String) {
        assertThat(greetPerson(greeters, name), equalTo("Salutations, $name."))
    }

    @ParameterizedTest
    @ValueSource(strings = ["_Slayer234$"])
    internal fun `greets people with speechless greeting`(name: String) {
        assertThat(greetPerson(greeters, name), equalTo("..."))
    }
}
