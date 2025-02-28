package controllers;

import dao.ProductDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import model.Product;

public class ProductManagementController {
    @FXML private TextField nameField;
    @FXML private TextField categoryField;
    @FXML private TextField priceField;
    @FXML private TextField stockField;
    @FXML private TableView<Product> productTable;
    @FXML private TableColumn<Product, Integer> idColumn;
    @FXML private TableColumn<Product, String> nameColumn;
    @FXML private TableColumn<Product, String> categoryColumn;
    @FXML private TableColumn<Product, Double> priceColumn;
    @FXML private TableColumn<Product, Integer> stockColumn;

    private ObservableList<Product> productList;

    public void initialize() {
        productList = FXCollections.observableArrayList();
        loadProductTable();
    }

    private void loadProductTable() {
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        categoryColumn.setCellValueFactory(cellData -> cellData.getValue().categoryProperty());
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        stockColumn.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
        productTable.setItems(productList);
        productList.addAll(ProductDAO.getAllProducts());
    }

    @FXML
    private void handleAddProduct() {
        String name = nameField.getText();
        String category = categoryField.getText();
        double price = Double.parseDouble(priceField.getText());
        int stock = Integer.parseInt(stockField.getText());

        Product newProduct = new Product(name, category, price, stock);
        ProductDAO.addProduct(newProduct);
        productList.clear();
        loadProductTable();
    }

    @FXML
    private void handleUpdateProduct() {
        Product selectedProduct = productTable.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            String name = nameField.getText();
            String category = categoryField.getText();
            double price = Double.parseDouble(priceField.getText());
            int stock = Integer.parseInt(stockField.getText());

            selectedProduct.setName(name);
            selectedProduct.setCategory(category);
            selectedProduct.setPrice(price);
            selectedProduct.setStock(stock);

            ProductDAO.updateProduct(selectedProduct);
            productList.clear();
            loadProductTable();
        }
    }

    @FXML
    private void handleDeleteProduct() {
        Product selectedProduct = productTable.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            ProductDAO.deleteProduct(selectedProduct);
            productList.clear();
            loadProductTable();
        }
    }
}
