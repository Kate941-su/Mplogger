import android.util.Log

actual fun printLog(tag: String, log: String, level: MPLog.LogLevel) {
    when(level){
        MPLog.LogLevel.Verbose -> Log.v(tag, log)
        MPLog.LogLevel.Debug -> Log.d(tag, log)
        MPLog.LogLevel.Info -> Log.i(tag, log)
        MPLog.LogLevel.Warning -> Log.w(tag, log)
        MPLog.LogLevel.Error -> Log.e(tag, log)
        MPLog.LogLevel.WTF -> Log.wtf(tag, log)
    }
}