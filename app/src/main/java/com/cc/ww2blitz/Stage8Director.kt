package com.cc.ww2blitz

import com.cc.ww2blitz.FormationSpawner.INTERCEPT_HP
import com.cc.ww2blitz.FormationSpawner.KAMI_HP
import com.cc.ww2blitz.FormationSpawner.S8_INTERCEPT_AT
import com.cc.ww2blitz.FormationSpawner.S8_KAMI_V_AT
import com.cc.ww2blitz.FormationSpawner.S8_UFO_AT
import com.cc.ww2blitz.FormationSpawner.S8_UFO_HP
import com.cc.ww2blitz.FormationSpawner.TYPE_HEAVY
import com.cc.ww2blitz.FormationSpawner.TYPE_INTERCEPTOR
import com.cc.ww2blitz.FormationSpawner.TYPE_KAMIKAZE

class Stage8Director : StageDirector {
  private var kamiVSpawned = false
  private var interceptSpawned = false
  private var ufoSpawned = false

  override fun reset() {
    kamiVSpawned = false
    interceptSpawned = false
    ufoSpawned = false
  }

  override fun tick(
    dt: Float,
    elapsed: Float,
    enemies: EnemyPoolManager,
    w: Float,
    h: Float,
    boss: BossController,
    allowBoss: Boolean,
    stageData: StageData,
    cue: DirectorCue,
  ) {
    if (!kamiVSpawned && elapsed >= S8_KAMI_V_AT) {
      kamiVSpawned = true
      FormationSpawner.spawnOrbitEscort(enemies, w, h, TYPE_KAMIKAZE, KAMI_HP, 0.26f, -1f)
      FormationSpawner.spawnOrbitEscort(enemies, w, h, TYPE_KAMIKAZE, KAMI_HP, 0.74f, 1f)
    }
    if (!interceptSpawned && elapsed >= S8_INTERCEPT_AT) {
      interceptSpawned = true
      FormationSpawner.spawnOrbitEscort(enemies, w, h, TYPE_INTERCEPTOR, INTERCEPT_HP, 0.24f, -1f)
      FormationSpawner.spawnOrbitEscort(enemies, w, h, TYPE_INTERCEPTOR, INTERCEPT_HP, 0.76f, 1f)
    }
    if (!ufoSpawned && elapsed >= S8_UFO_AT) {
      ufoSpawned = true
      FormationSpawner.spawnOrbitEscort(enemies, w, h, TYPE_HEAVY, S8_UFO_HP, 0.22f, -1f)
      FormationSpawner.spawnOrbitEscort(enemies, w, h, TYPE_HEAVY, S8_UFO_HP, 0.78f, 1f)
    }
  }
}
