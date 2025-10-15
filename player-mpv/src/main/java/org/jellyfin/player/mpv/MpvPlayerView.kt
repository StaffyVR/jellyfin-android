package org.jellyfin.player.mpv

import android.content.Context
import android.util.AttributeSet
import android.view.Surface
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.FrameLayout

/**
 * Simple view wrapper for MpvPlayer that owns a SurfaceView and attaches
 * the surface to the MpvPlayer when created. This can be extended with
 * more UI controls as needed.
 */
class MpvPlayerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs), SurfaceHolder.Callback {

    var player: MpvPlayer? = null
    private val surfaceView: SurfaceView = SurfaceView(context)

    init {
        // Add the SurfaceView to fill this layout
        addView(
            surfaceView,
            LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        )
        // Register this view as callback for surface events
        surfaceView.holder.addCallback(this)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        // Notify player of new surface
        player?.attachSurface(holder.surface)
    }

    override fun surfaceChanged(
        holder: SurfaceHolder,
        format: Int,
        width: Int,
        height: Int
    ) {
        // Currently a no-op; could handle size changes here
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        // Detach surface when destroyed
        player?.attachSurface(Surface(null))
    }
}
