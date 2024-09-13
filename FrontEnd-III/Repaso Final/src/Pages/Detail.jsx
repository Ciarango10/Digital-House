import axios from "axios";
import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

const Detail = () => {
  const [detail, setDetail] = useState({});
  const { id } = useParams();
  console.log(id);
  const url = "https://rickandmortyapi.com/api/character/" + id;
  useEffect(() => {
    axios(url).then((res) => {
      console.log(res.data);
      setDetail(res.data);
    });
  }, []);

  return (
    <div>
      <h1>{detail.name}</h1>
      <img src={detail.image} alt="" />
      <h3>Estado: {detail.status}</h3>
    </div>
  );
};

export default Detail;
