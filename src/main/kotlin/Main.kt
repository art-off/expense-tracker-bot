import dev.inmo.tgbotapi.bot.ktor.telegramBot;
import dev.inmo.tgbotapi.extensions.api.send.reply
import dev.inmo.tgbotapi.extensions.behaviour_builder.buildBehaviourWithLongPolling;
import dev.inmo.tgbotapi.extensions.behaviour_builder.triggers_handling.onCommand

suspend fun main() {
    val bot = telegramBot(getEnvOrFail("TG_BOT_TOKEN"))

    bot.buildBehaviourWithLongPolling {
        onCommand("start") {
            reply(it, "Hello, world! sdlfkjsdlfkj")
        }
    }.join()
}

fun getEnvOrFail(key: String): String {
    return System.getenv(key) ?: throw IllegalStateException("Environment variable $key is not defined")
}
