package com.example.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.MeetingRoom
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.model.ConnectionStatus
import com.example.ui.components.ConnectionStatusBar
import com.example.ui.theme.*

@Composable
fun MainHubScreen(
    connectionStatus: ConnectionStatus,
    pendingSyncCount: Int,
    onSyncClick: () -> Unit,
    onVincularDispositivoClick: () -> Unit,
    onGerenteClick: () -> Unit,
    onRecepcionClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            ConnectionStatusBar(
                status = connectionStatus,
                pendingSyncCount = pendingSyncCount,
                onSyncClick = onSyncClick
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Branding Section
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Hotel Logo / Emblem
                Box(
                    modifier = Modifier
                        .size(110.dp)
                        .clip(RoundedCornerShape(24.dp))
                        .background(
                            Brush.linearGradient(
                                colors = listOf(HotelNavyDark, HotelNavyLight)
                            )
                        )
                        .padding(4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_hotel_logo),
                        contentDescription = "Hotel Rivera Logo",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(20.dp))
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "HOTEL RIVERA",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 3.sp,
                    color = HotelNavy,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Sistema de Gestión y Operaciones",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = HotelGoldDark,
                    letterSpacing = 1.sp
                )

                Text(
                    text = "Sincronización Multi-dispositivo en Tiempo Real",
                    fontSize = 12.sp,
                    color = TextDarkSecondary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            // Main Primary Buttons Section (Only these 3 buttons per section 1)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 440.dp),
                verticalArrangement = Arrangement.spacedBy(18.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // [ VINCULAR DISPOSITIVO ]
                Button(
                    onClick = onVincularDispositivoClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .testTag("btn_vincular_dispositivo"),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ButtonPrimary,
                        contentColor = ButtonPrimaryText
                    ),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.QrCodeScanner,
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = ButtonAccent
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "VINCULAR DISPOSITIVO",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )
                }

                // [ GERENTE 🔐 ]
                Button(
                    onClick = onGerenteClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .testTag("btn_gerente"),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ButtonPrimary,
                        contentColor = ButtonPrimaryText
                    ),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Key,
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = ButtonAccent
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "GERENTE 🔐",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )
                }

                // [ RECEPCIÓN ]
                Button(
                    onClick = onRecepcionClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .testTag("btn_recepcion"),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ButtonAccent,
                        contentColor = ButtonAccentText
                    ),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.MeetingRoom,
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = ButtonAccentText
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "RECEPCIÓN",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 1.sp
                    )
                }
            }

            // Footer
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(bottom = 12.dp)
            ) {
                Text(
                    text = "Hotel Rivera v1.0 • Todos los datos protegidos",
                    fontSize = 11.sp,
                    color = TextDarkSecondary
                )
            }
        }
    }
}

