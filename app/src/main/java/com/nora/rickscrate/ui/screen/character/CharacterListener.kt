package com.nora.rickscrate.ui.screen.character

import android.view.View
import com.nora.rickscrate.domain.model.Character

interface CharacterListener {
    fun onItemClicked(view: View, item: Character)
}