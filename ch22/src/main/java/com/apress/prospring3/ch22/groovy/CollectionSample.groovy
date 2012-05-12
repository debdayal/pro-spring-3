/**
 * Created on Jan 16, 2012
 */
package com.apress.prospring3.ch22.groovy

// Define a list as an ArrayList
def list = ['This', 'is', 'Clarence']
assert list.size() == 3
assert list.class == ArrayList

// Reverse a list
assert list.reverse() == ['Clarence', 'is', 'This']

// Sort a list by string size
assert list.sort{ it.size() } == ['is', 'This', 'Clarence']

// Sub list
assert list[0..1] == ['is', 'This']

// Use << for append item
assert list << 'Ho' == ['is', 'This', 'Clarence', 'Ho']