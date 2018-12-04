package PublicParckingProject;

import Trees.BinaryTreeNode;

/*
# Binary Tree Node.
#
# Created by Msc. Carlos Andres Sierra on April 2018.
# Copyright (c) 2018  Msc. Carlos Andres Sierra. Research Group on Artificial Life - ALIFE. All rights reserved.
#
# This file is part of DataStructuresTemplates.
#
# DataStructuresTemplates is free software: you can redistribute it and/or modify it under the terms of the
# GNU General Public License as published by the Free Software Foundation, version 3.
*/

/**
 * This class represents the behavior of Binary Tree Node
 * 
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class BinaryNodeExample implements BinaryTreeNode {

	public int value;
	public BinaryNodeExample left;
	public BinaryNodeExample right;

	// Data Structure Node Client
	String Name = null;
	String Vehicle = null;
	String Placa = null;
	String HoraIn = null;
	String HoraOut = null;
	int bill = 0;

	BinaryNodeExample next = null;

	public BinaryNodeExample(String placa) {

		this.Placa = placa;
	}

	public BinaryNodeExample(String name, String vehicle, String placa, String horaIn) {

		this.Name = name;
		this.Vehicle = vehicle;
		this.Placa = placa;
		this.HoraIn = horaIn;
	}

	public BinaryNodeExample(String name, String vehicle, String placa, String horaIn, String horaOut, int pay) {

		this.Name = name;
		this.Vehicle = vehicle;
		this.Placa = placa;
		this.HoraIn = horaIn;
		this.HoraOut = horaOut;
		this.bill = pay;
	}

	public BinaryNodeExample(int value) {
		this.value = value;
	}

	@Override
	public void setLeft(BinaryTreeNode node) {
		left = (BinaryNodeExample) node;
	}

	@Override
	public BinaryTreeNode getLeft() {
		return left;
	}

	@Override
	public void setRight(BinaryTreeNode node) {
		right = (BinaryNodeExample) node;
	}

	@Override
	public BinaryTreeNode getRight() {
		return right;
	}

	@Override
	public BinaryTreeNode clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEqual(BinaryTreeNode node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLessThan(BinaryTreeNode node) {
		// TODO Auto-generated method stub
		return false;
	}

}