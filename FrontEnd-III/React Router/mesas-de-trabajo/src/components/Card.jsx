import React from 'react'

const Card = ({data}) => {
  return (
    <div className='card'>
        <h3>{data.name}</h3>
        <p>{data.price}</p>
        <img src={data.image} alt="beer-detail" />
    </div>
  )
}

export default Card