import platform.Foundation.NSDate
import platform.Foundation.NSDateFormatter

actual fun printLog(tag: String, log: String, level: MPLog.LogLevel) {
    val date = NSDate() // Current date and time
    val formatter = NSDateFormatter()
    formatter.dateFormat = "yyyy-MM-dd HH:mm:ss"
    val dateString = formatter.stringFromDate(date)
    when (level) {
        MPLog.LogLevel.Verbose -> println("$dateString 🔍[${level.showName}] $log")
        MPLog.LogLevel.Debug -> println("$dateString 💻${level.showName} $log")
        MPLog.LogLevel.Info -> println("$dateString ℹ️${level.showName} $log")
        MPLog.LogLevel.Warning -> println("$dateString ⚠️${level.showName} $log")
        MPLog.LogLevel.Error -> println("$dateString ❌${level.showName} $log")
        MPLog.LogLevel.WTF -> println("$dateString 💣${level.showName} $log")
    }
}