package com.hanakusoman.hola

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.hanakusoman.hola.models.Category
import kotlinx.android.synthetic.main.fragment_content.*
import kotlinx.android.synthetic.main.fragment_content.view.*
import android.content.Intent
import android.net.Proxy.getHost
import android.net.Uri
import android.webkit.WebSettings


/**
 * Created by taihe on 2017/10/19.
 */
class ContentFragment: Fragment() {

    companion object {
        fun createInstance(category: Category): ContentFragment{
            var fragment = ContentFragment()
            var bundle = Bundle()
            bundle.putSerializable("CATEGORY" , category)
            fragment.arguments = bundle
            return fragment
        }
    }

    private var category: Category? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        category = arguments.get("CATEGORY") as Category
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_content, container, false)
        val webView = view.web_view
        webView.webViewClient = WebViewClient()
        val webViewSettings = webView.settings
        webViewSettings.javaScriptEnabled = true
        webViewSettings.domStorageEnabled = true
        webViewSettings.loadWithOverviewMode = true
        webViewSettings.setAppCacheEnabled(true)
        webViewSettings.setRenderPriority(WebSettings.RenderPriority.HIGH)
        webViewSettings.cacheMode = WebSettings.LOAD_NO_CACHE
        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null)

        return view
    }

    override fun onResume() {
        super.onResume()
        web_view.loadUrl(category!!.url)
    }

    override fun onPause() {
        super.onPause()

        web_view.stopLoading()
    }

    inner class MyAppWebViewClient : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            if (Uri.parse(url).getHost().endsWith("example.com")) {
                return false
            }

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            view.context.startActivity(intent)
            return true
        }
    }
}