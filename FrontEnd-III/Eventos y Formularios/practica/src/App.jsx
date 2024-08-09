import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Rejuvenecedor } from './Components/Rejuvenecedor'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <Rejuvenecedor />
    </>
  )
}

export default App
