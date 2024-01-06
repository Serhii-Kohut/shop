package com.myown.shop.dto;

import com.myown.shop.entity.enumeration.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {
    Long id;

    @NotNull
    Date entryDate;

    @NotNull
    Long itemCode;

    @NotBlank
    String itemName;

    @NotNull
    Long itemQuantity;

    Status status;
}
