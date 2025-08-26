package com.hhd.jewelry.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "stock_movements")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movementId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Enumerated(EnumType.STRING)
    private ChangeType changeType;

    private Integer quantity;

    @Column(columnDefinition = "TEXT")
    private String note;

    private LocalDateTime createdAt;

    public enum ChangeType {
        IMPORT, SALE, ADJUSTMENT
    }
}
