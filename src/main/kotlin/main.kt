import kotlin.text.RegexOption.IGNORE_CASE

private val greeters = setOf(FormalGreeter(), InformalGreeter(), FamiliarGreeter())

fun main(args: Array<String>) {
    val name = args.firstOrNull() ?: throw IllegalStateException("Usage: must pass a single name argument")
    println(greetPerson(greeters, name))
}

fun greetPerson(greeters: Collection<Greeter>, name: String): String {
    return greeters.firstOrNull { it.isAppropriate(name) }
        ?.greet(name)
        ?: "..."
}

interface Greeter {
    fun isAppropriate(name: String): Boolean
    fun greet(name: String): String
}

class FamiliarGreeter : Greeter {
    override fun isAppropriate(name: String): Boolean = name.matches(Regex("""^[a-f].*""", IGNORE_CASE))
    override fun greet(name: String): String = "How you doin', $name?"
}

class InformalGreeter : Greeter {
    override fun isAppropriate(name: String): Boolean = name.matches(Regex("""^[g-s].*""", IGNORE_CASE))
    override fun greet(name: String): String = "Howdy, $name!"
}

class FormalGreeter : Greeter {
    override fun isAppropriate(name: String): Boolean = name.matches(Regex("""^[t-z].*""", IGNORE_CASE))
    override fun greet(name: String): String = "Salutations, $name."
}
