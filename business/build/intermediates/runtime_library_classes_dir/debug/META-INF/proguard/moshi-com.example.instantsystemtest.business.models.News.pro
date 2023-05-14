-if class com.example.instantsystemtest.business.models.News
-keepnames class com.example.instantsystemtest.business.models.News
-if class com.example.instantsystemtest.business.models.News
-keep class com.example.instantsystemtest.business.models.NewsJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
