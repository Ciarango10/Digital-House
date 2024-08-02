import AppStyles from '../Styles/App.module.css'

const productos = [
  {
      "id": 0,
      "nombre": "Macbook Air 13 Chip M1 256gb",
      "imagen": "https://m.media-amazon.com/images/I/41O807iqbCL._AC_SX522_.jpg",
      "precio": "$ 1499.00"
  },
  {
      "id": 1,
      "nombre": "Amazon Echo Dot (4a Gen.)", 
      "imagen": "https://m.media-amazon.com/images/I/714Rq4k05UL._AC_SL1000_.jpg",
      "precio": "$ 14.99"
  },
  {
      "id": 2,
      "nombre": "Cámara IP Inalámbrica 360°",
      "imagen": "https://m.media-amazon.com/images/I/51F70OM213S._AC_SL1000_.jpg",
      "precio": "$ 39.00"
  },
  {
      "id": 3,
      "nombre": "CERRADURA DIGITAL INTELIGENTE FORTEZZA ZIGBEE",
      "imagen": "https://m.media-amazon.com/images/I/51RXeqMLceL._AC_SL1500_.jpg",
      "precio": "$ 99.00"
  }
]

function App() {
  return (
    <div>
      <h1 className={AppStyles.title}>Productos</h1>

      <ul className={AppStyles.container}>
        {productos.map(producto => 
        <li key={producto.id} className={AppStyles.card}>
            <h2 className={AppStyles.cardTitle}>{producto.nombre}</h2>
            <img src={producto.imagen} width={250} height={250}/>
            <h3 className={AppStyles.cardPrice}>{producto.precio}</h3>
        </li>)}
      </ul>
    </div>
  );
}

export default App;
