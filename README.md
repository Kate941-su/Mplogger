# MpLogger
A super light weight Log Output library in Compose Multiplatform / Kotlin Multiplatform for iOS and Android.

## Overview
You can see the log in Logcat(Android) and Console(Xcode).

### Log level
- Verbose
- Debug
- Info
- Warning
- Error
- WTF

### Android
Like `Log` included in the Android standard library, You can see the log outputted by `Mplogger` in your Logcat.

#### Verbose
```shell
2024-11-24 10:28:51.912  4903-4903  Mplogger example        org.kaitokitaya.credentialmanager    V  VERBOSE
```

#### Debug
```shell
2024-11-24 10:28:57.204  4903-4903  Mplogger example        org.kaitokitaya.credentialmanager    D  DEBUG
```

#### Info
```shell
2024-11-24 10:29:37.029  4903-4903  Mplogger example        org.kaitokitaya.credentialmanager    I  INFO
```

#### Warning
```shell
2024-11-24 10:29:38.391  4903-4903  Mplogger example        org.kaitokitaya.credentialmanager    W  WARNING
```

#### Error
```shell
2024-11-24 10:29:39.264  4903-4903  Mplogger example        org.kaitokitaya.credentialmanager    E  ERROR
```

#### WTF
```shell
2024-11-24 10:29:40.275  4903-4903  Mplogger example        org.kaitokitaya.credentialmanager    E  WTF!
```

### iOS
The log doesn't see the Android environment like Logcat. You should launch your application by Xcode.
And you can see the log in your console in Xcode

#### Verbose
```shell
2024-11-24 10:33:34 🔍[VERBOSE] VERBOSE
```

#### Debug
```shell
2024-11-24 10:33:35 💻DEBUG DEBUG
```

#### Info
```shell
2024-11-24 10:33:36 ℹ️INFO INFO
```

#### Warning
```shell
2024-11-24 10:33:36 ⚠️WARNING WARNING
```

#### Error
```shell
2024-11-24 10:33:36 ❌ERROR ERROR
```

#### WTF
```shell
2024-11-24 10:33:37 💣WTF WTF!
```

These kinds of tags are adhered by [Android logging rule](https://source.android.com/docs/core/tests/debug/understanding-logging)

## Install

```kotlin
implementation("io.github.kate941-su:mplogger:1.0.0")
```

## How to use

The following code is a part of the UI implementation in Overview.

```kotlin
Button(
    onClick = { MPLog.tag("Mplogger example").v("VERBOSE") },
    colors = ButtonDefaults.buttonColors(
        backgroundColor = Color.Gray,
        contentColor = Color.White
    )
) {
    Text("v")
}
```

The format of outputting logs are the below. 
```shell
MPLog.tag("<TAG_NAME>").v("<VERBOSE_MESSAGE>")
```

If you want to reuse the MPLog which has a same tag you can instantiate the MPlog.

```shell
val helloWorldLog = MPLog.tag("<TAG_NAME>")
helloWorldLog.i("<INFORMATION_MESSAGE>")
```
