import React from 'react'
import CardStyles from "../Styles/Card.module.css"

const Card = ({pokemon}) => {
  return (
    <div className={CardStyles.card}>
        <h2>{pokemon.name}</h2>
        <img src={pokemon.sprites.front_default} alt={pokemon.name} />
    </div>
  )
}

export default Card