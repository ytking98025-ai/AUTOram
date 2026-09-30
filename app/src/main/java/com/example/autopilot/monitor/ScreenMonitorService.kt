package com.example.autopilot.monitor

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo

class ScreenMonitorService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        val root = rootInActiveWindow ?: return

        // Example: inspect visible text. Add explicit rules here.
        val texts = ArrayList<String>()
        collectText(root, texts)

        // TODO:
        // 1. Detect the app/package.
        // 2. Match a safe, user-defined condition.
        // 3. Perform an action with node.performAction().
        // Avoid uncontrolled clicking loops.
    }

    private fun collectText(node: AccessibilityNodeInfo, out: MutableList<String>) {
        node.text?.toString()?.takeIf { it.isNotBlank() }?.let(out::add)
        for (i in 0 until node.childCount) {
            node.getChild(i)?.let { collectText(it, out) }
        }
    }

    override fun onInterrupt() {}
}
