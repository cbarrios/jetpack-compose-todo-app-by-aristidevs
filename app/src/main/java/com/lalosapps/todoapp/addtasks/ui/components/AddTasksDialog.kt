package com.lalosapps.todoapp.addtasks.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun AddTasksDialog(
    visible: Boolean,
    onDismiss: () -> Unit,
    onTaskAdded: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    if (visible) {
        var task by rememberSaveable { mutableStateOf("") }
        Dialog(onDismissRequest = onDismiss) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colors.background)
                    .padding(16.dp)

            ) {
                Text(
                    text = "Add task",
                    fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = task,
                    onValueChange = { task = it },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { onTaskAdded(task) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Add")
                }
            }
        }
    }
}