import { describe, expect, test, vi } from "vitest";
import Form from "../Components/Form";
import { fireEvent, render, screen } from "@testing-library/react";

describe("Testing Form component", () => {
    test("Should not recieve numbers", () => {
        render(<Form />);
        const input = screen.getByTestId("input");
        fireEvent.change(input, {target: {value: 123}})
        expect(screen.getByText("El input no admite valores numéricos")).toBeInTheDocument();
    });

    test("Should call button function ", () => {
        const handleClick = vi.fn();
        render(<Form handleClick={handleClick} />);
        const button = screen.getByText("Enviar");
        fireEvent.click(button);
        expect(handleClick).toBeCalledTimes(1);
    });
});