delete from CustomerOrderItem;
delete from CustomerOrder;
delete from FishBatch;
delete from PurchaseOrder;
delete from Customer;
delete from Employee;
delete from FishType;

INSERT INTO `fish_store`.`FishType` (`fishTypeId`, `name`) VALUES ('1', 'Seledka');
INSERT INTO `fish_store`.`FishType` (`fishTypeId`, `name`) VALUES ('2', 'Moiva');
INSERT INTO `fish_store`.`FishType` (`fishTypeId`, `name`) VALUES ('3', 'Taranka');
INSERT INTO `fish_store`.`FishType` (`fishTypeId`, `name`) VALUES ('4', 'Som');
INSERT INTO `fish_store`.`FishType` (`fishTypeId`, `name`) VALUES ('5', 'Kil\'ka');
INSERT INTO `fish_store`.`FishType` (`fishTypeId`, `name`) VALUES ('6', 'Karas\'');
INSERT INTO `fish_store`.`FishType` (`fishTypeId`, `name`) VALUES ('7', 'Okun\'');
INSERT INTO `fish_store`.`FishType` (`fishTypeId`, `name`) VALUES ('8', 'Shuka');
INSERT INTO `fish_store`.`FishType` (`fishTypeId`, `name`) VALUES ('9', 'Treska');
INSERT INTO `fish_store`.`FishType` (`fishTypeId`, `name`) VALUES ('10', 'Losos\'');


INSERT INTO `fish_store`.`Employee` (`employeeId`, `name`, `login`, `password`, `role`, `suspended`, `email`) VALUES ('1', 'Petya', 'petya', '111', '4', '0', '1@1');
INSERT INTO `fish_store`.`Employee` (`employeeId`, `name`, `login`, `password`, `role`, `suspended`, `email`) VALUES ('2', 'Vasia', 'vasia', '222', '1', '0', '2@2');
INSERT INTO `fish_store`.`Employee` (`employeeId`, `name`, `login`, `password`, `role`, `suspended`, `email`) VALUES ('3', 'Misha', 'misha', '333', '2', '0', '3@3');
INSERT INTO `fish_store`.`Employee` (`employeeId`, `name`, `login`, `password`, `role`, `suspended`, `email`) VALUES ('4', 'Dima', 'dima', '444', '3', '0', '4@4');
INSERT INTO `fish_store`.`Employee` (`employeeId`, `name`, `login`, `password`, `role`, `suspended`, `email`) VALUES ('5', 'Sasha', 'sasha', '555', '3', '1', '5@5');


INSERT INTO `fish_store`.`Customer` (`customerId`, `name`, `email`, `login`, `password`, `registrationDate`, `prepaymentRights`) VALUES ('1', 'Olga', '1@1', 'olga', '111', '2011-01-01 00:00:00', '0');
INSERT INTO `fish_store`.`Customer` (`customerId`, `name`, `email`, `login`, `password`, `registrationDate`, `prepaymentRights`) VALUES ('2', 'Elena', '2@2', 'elena', '222', '2012-02-02 00:00:00', '10');
INSERT INTO `fish_store`.`Customer` (`customerId`, `name`, `email`, `login`, `password`, `registrationDate`, `prepaymentRights`) VALUES ('3', 'Tanya', '3@3', 'tanya', '333', '2013-03-03 00:00:00', '15');

INSERT INTO `fish_store`.`PurchaseOrder` (`purchaseOrderId`, `dateOrdered`, `dateArrived`, `acceptedToStoreBy`) VALUES ('1', '2011-05-05', '2011-05-10', '3');
INSERT INTO `fish_store`.`PurchaseOrder` (`purchaseOrderId`, `dateOrdered`, `dateArrived`, `acceptedToStoreBy`) VALUES ('2', '2012-02-02', '2012-02-10', '3');
INSERT INTO `fish_store`.`PurchaseOrder` (`purchaseOrderId`, `dateOrdered`, `dateArrived`, `acceptedToStoreBy`) VALUES ('3', '2013-01-05', '2013-01-10', '3');


INSERT INTO `fish_store`.`FishBatch` (`fishBatchId`, `quality`, `weightOrdered`, `weightArrived`, `weightLeft`, `cost`, `fishTypeId`, `purchaseOrderId`, `writtenOff`, `salePrice`, `onSale`) VALUES ('1', 'cool', '10', '10', '10', '123', '1', '1', '0', '465', '1');
INSERT INTO `fish_store`.`FishBatch` (`fishBatchId`, `quality`, `weightOrdered`, `weightArrived`, `weightLeft`, `cost`, `fishTypeId`, `purchaseOrderId`, `writtenOff`, `salePrice`, `onSale`) VALUES ('2', 'cool', '20', '20', '20', '547', '2', '1', '0', '984', '1');
INSERT INTO `fish_store`.`FishBatch` (`fishBatchId`, `quality`, `weightOrdered`, `weightArrived`, `weightLeft`, `cost`, `fishTypeId`, `purchaseOrderId`, `writtenOff`, `salePrice`, `onSale`) VALUES ('3', 'cool', '30', '30', '30', '465', '3', '1', '0', '459', '1');
INSERT INTO `fish_store`.`FishBatch` (`fishBatchId`, `quality`, `weightOrdered`, `weightArrived`, `weightLeft`, `cost`, `fishTypeId`, `purchaseOrderId`, `writtenOff`, `salePrice`, `onSale`) VALUES ('4', 'cool', '40', '40', '40', '4651320', '4', '2', '0', '753', '0');
INSERT INTO `fish_store`.`FishBatch` (`fishBatchId`, `quality`, `weightOrdered`, `weightArrived`, `weightLeft`, `cost`, `fishTypeId`, `purchaseOrderId`, `writtenOff`, `salePrice`, `onSale`) VALUES ('5', 'cool', '50', '50', '50', '8456', '5', '2', '0', '1234', '1');
INSERT INTO `fish_store`.`FishBatch` (`fishBatchId`, `quality`, `weightOrdered`, `weightArrived`, `weightLeft`, `cost`, `fishTypeId`, `purchaseOrderId`, `writtenOff`, `salePrice`, `onSale`) VALUES ('6', 'cool', '60', '60', '60', '46854', '6', '2', '0', '4561', '0');
INSERT INTO `fish_store`.`FishBatch` (`fishBatchId`, `quality`, `weightOrdered`, `weightArrived`, `weightLeft`, `cost`, `fishTypeId`, `purchaseOrderId`, `writtenOff`, `salePrice`, `onSale`) VALUES ('7', 'cool', '70', '70', '70', '789', '7', '3', '0', '48748', '0');
INSERT INTO `fish_store`.`FishBatch` (`fishBatchId`, `quality`, `weightOrdered`, `weightArrived`, `weightLeft`, `cost`, `fishTypeId`, `purchaseOrderId`, `writtenOff`, `salePrice`, `onSale`) VALUES ('8', 'cool', '80', '80', '80', '12', '8', '3', '0', '123', '1');
INSERT INTO `fish_store`.`FishBatch` (`fishBatchId`, `quality`, `weightOrdered`, `weightArrived`, `weightLeft`, `cost`, `fishTypeId`, `purchaseOrderId`, `writtenOff`, `salePrice`, `onSale`) VALUES ('9', 'cool', '90', '90', '90', '46', '9', '3', '0', '489', '1');
INSERT INTO `fish_store`.`FishBatch` (`fishBatchId`, `quality`, `weightOrdered`, `weightArrived`, `weightLeft`, `cost`, `fishTypeId`, `purchaseOrderId`, `writtenOff`, `salePrice`, `onSale`) VALUES ('10', 'cool', '100', '100', '100', '12', '10', '3', '0', '123', '1');


INSERT INTO `fish_store`.`CustomerOrder` (`customerOrderId`, `date`, `status`, `customerId`, `sumPayed`, `approvedBy`) VALUES ('1', '2012-10-10', '1', '1', '1000', '3');
INSERT INTO `fish_store`.`CustomerOrder` (`customerOrderId`, `date`, `status`, `customerId`, `sumPayed`, `approvedBy`) VALUES ('2', '2013-10-10', '1', '2', '2000', '3');
INSERT INTO `fish_store`.`CustomerOrder` (`customerOrderId`, `date`, `status`, `customerId`, `sumPayed`, `approvedBy`) VALUES ('3', '2014-10-10', '1', '3', '3000', '3');


INSERT INTO `fish_store`.`CustomerOrderItem` (`customerOrderItemId`, `weight`, `fishBatchId`, `customerOrderId`, `sum`) VALUES ('1', '10', '1', '1', '1213');
INSERT INTO `fish_store`.`CustomerOrderItem` (`customerOrderItemId`, `weight`, `fishBatchId`, `customerOrderId`, `sum`) VALUES ('2', '15', '2', '1', '144');
INSERT INTO `fish_store`.`CustomerOrderItem` (`customerOrderItemId`, `weight`, `fishBatchId`, `customerOrderId`, `sum`) VALUES ('3', '20', '3', '1', '102');
INSERT INTO `fish_store`.`CustomerOrderItem` (`customerOrderItemId`, `weight`, `fishBatchId`, `customerOrderId`, `sum`) VALUES ('4', '30', '4', '2', '145');
INSERT INTO `fish_store`.`CustomerOrderItem` (`customerOrderItemId`, `weight`, `fishBatchId`, `customerOrderId`, `sum`) VALUES ('5', '45', '5', '2', '178');
INSERT INTO `fish_store`.`CustomerOrderItem` (`customerOrderItemId`, `weight`, `fishBatchId`, `customerOrderId`, `sum`) VALUES ('6', '85', '6', '3', '211');
INSERT INTO `fish_store`.`CustomerOrderItem` (`customerOrderItemId`, `weight`, `fishBatchId`, `customerOrderId`, `sum`) VALUES ('7', '90', '7', '3', '78');
INSERT INTO `fish_store`.`CustomerOrderItem` (`customerOrderItemId`, `weight`, `fishBatchId`, `customerOrderId`, `sum`) VALUES ('8', '123', '8', '3', '301');

