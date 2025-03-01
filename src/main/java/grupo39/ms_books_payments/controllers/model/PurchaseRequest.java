package grupo39.ms_books_payments.controllers.model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@Data
@NoArgsConstructor
public class PurchaseRequest {

    @NotNull(message = "`books` cannot be null")
    @NotEmpty(message = "`books` cannot be empty")
    private List<String> books;

}
