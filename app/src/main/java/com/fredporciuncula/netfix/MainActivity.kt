/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.fredporciuncula.netfix

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.os.Bundle

private const val netflixPackageName = "com.netflix.ninja"

class MainActivity : Activity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    triggerNetflixRebirthAndFinish()
  }

  private fun triggerNetflixRebirthAndFinish() {
    activityManager.killBackgroundProcesses(netflixPackageName)
    startActivity(packageManager.getLaunchIntentForPackage(netflixPackageName))
    finish()
  }
}

inline val Context.activityManager get() = getSystemService(Activity.ACTIVITY_SERVICE) as ActivityManager
