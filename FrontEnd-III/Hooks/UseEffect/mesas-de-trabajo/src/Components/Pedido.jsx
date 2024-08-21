import React from 'react'
import { useState } from 'react';
import { useEffect } from 'react'

const Pedido = () => {
    const [pedido, setPedido] = useState([]);

    useEffect(() => {
        setTimeout(() => {
            setPedido(["Pizza"]);
        }, 2000);
    }, []);

    useEffect(() => {
        if(pedido.length > 0) {
            console.log("El componente fue actualizado");
        }
    }, [pedido]);

    useEffect(() => {
        return () => {
            console.log("Se desmontó el componente");
        }
    }, []);

    return (
        <div>{pedido}</div>
    )
}

export default Pedido