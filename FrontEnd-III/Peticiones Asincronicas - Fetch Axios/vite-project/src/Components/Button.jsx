const Button = (props) => {
  return (
    <button disabled={props.disabled} onClick={props.onClick}>
      {props.children}
    </button>
  );
};

export default Button;
