import React from 'react'
import { Link } from 'react-router-dom'

const Navbar = () => {
  return (
    <nav>
        <Link to="/"><h4>Home</h4></Link>
        <Link to="/contacto"><h4>Contacto</h4></Link>
        <Link to="/beer/:id"><h4>Cervezas</h4></Link>
    </nav>
  )
}

export default Navbar