class MPLog(private val tag: String) {
    enum class LogLevel(private val string: String) {
        Verbose("VERBOSE"),
        Debug("DEBUG"),
        Info("INFO"),
        Warning("WARNING"),
        Error("ERROR"),
        WTF("WTF");
        val showName: String
            get() = string
    }
    companion object Factory {
        fun tag(tag: String): MPLog = MPLog(tag = tag)
    }
    fun v(message: String) {
        printLog(tag = tag, log = message, level = LogLevel.Verbose)
    }
    fun d(message: String) {
        printLog(tag = tag, log = message, level = LogLevel.Debug)
    }
    fun i(message: String) {
        printLog(tag = tag, log = message, level = LogLevel.Info)
    }
    fun w(message: String) {
        printLog(tag = tag, log = message, level = LogLevel.Warning)
    }
    fun e(message: String) {
        printLog(tag = tag, log = message, level = LogLevel.Error)
    }
    fun wtf(message: String) {
        printLog(tag = tag, log = message, level = LogLevel.WTF)
    }
}

expect fun printLog(
    tag: String,
    log: String,
    level: MPLog.LogLevel
)
