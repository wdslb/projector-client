/*
 * Copyright (c) 2019-2021, JetBrains s.r.o. and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation. JetBrains designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact JetBrains, Na Hrebenech II 1718/10, Prague, 14000, Czech Republic
 * if you need additional information or have any questions.
 */
package org.jetbrains.projector.server.core.websocket

import org.java_websocket.WebSocket
import org.jetbrains.projector.common.protocol.toClient.MainWindow
import java.nio.ByteBuffer

public abstract class TransportBuilder {
  public lateinit var onStart: () -> Unit
  public lateinit var onError: (WebSocket?, Exception) -> Unit
  public lateinit var onWsOpen: (connection: WebSocket) -> Unit
  public lateinit var onWsClose: (connection: WebSocket) -> Unit
  public lateinit var onWsMessageString: (connection: WebSocket, message: String) -> Unit
  public lateinit var onWsMessageByteBuffer: (connection: WebSocket, message: ByteBuffer) -> Unit
  public lateinit var onGetRequest: (path: String) -> GetRequestResult
  public lateinit var getMainWindow: () -> List<MainWindow>

  public abstract  fun build(): HttpWsTransport
}
