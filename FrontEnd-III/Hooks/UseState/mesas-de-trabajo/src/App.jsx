import { useState } from 'react'
import './App.css'
import Card from './Components/Card'
import Lista from './Components/Lista'
import { tareas } from './utils/tareas'

function App() {
  const [tasks, setTasks] = useState([]);
  console.log(tasks);

  return (
    <div style={{display:'flex'}}>
      <div style={{display:'flex', flexDirection:'column'}}>
        {tareas.map((tarea) => (
          <Card key={tarea.id} tarea={tarea} tasks={tasks} setTasks={setTasks}></Card>
        ))}
      </div>
      <div style={{display:'flex', flexDirection:'column'}}>
        {tasks.map((task) => (
          <Lista task={task}/>
        ))}  
      </div>
    </div>
  )
}

export default App
