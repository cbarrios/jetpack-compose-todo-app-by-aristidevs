package com.lalosapps.todoapp.addtasks.ui.components

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.lalosapps.todoapp.addtasks.domain.model.Task

@Composable
fun TasksList(
    tasks: List<Task>,
    onTaskCheckedChange: (Long, Boolean) -> Unit,
    onTaskDeleted: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(tasks, key = { task -> task.id }) { task ->
            TaskItem(
                task = task,
                onTaskCheckedChange = onTaskCheckedChange,
                onTaskDeleted = onTaskDeleted
            )
        }
    }
}

@Composable
fun TaskItem(
    task: Task,
    onTaskCheckedChange: (Long, Boolean) -> Unit,
    onTaskDeleted: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 8.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onLongPress = {
                        onTaskDeleted(task.id)
                    }
                )
            },
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = task.text,
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            )
            Checkbox(
                checked = task.checked,
                onCheckedChange = { onTaskCheckedChange(task.id, it) }
            )
        }
    }
}