import Card from "../Components/Card";
import { useCharStates } from "../Context";

const Home = () => {
  const { state } = useCharStates();

  return (
    <div>
      {state.list.map((char) => (
        <Card key={char.id} char={char} />
      ))}
    </div>
  );
};

export default Home;
