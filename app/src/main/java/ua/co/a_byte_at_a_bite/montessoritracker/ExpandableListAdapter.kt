package ua.co.a_byte_at_a_bite.montessoritracker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView

data class Presentation(val name: String)

data class Topic(val name: String, val presentations: List<Presentation>)

class ExpandableListAdapter(
    private val context: Context,
    private val topics: List<Topic>
) : BaseExpandableListAdapter() {

    override fun getGroupCount(): Int = topics.size

    override fun getChildrenCount(groupPosition: Int): Int = topics[groupPosition].presentations.size

    override fun getGroup(groupPosition: Int): Any = topics[groupPosition]

    override fun getChild(groupPosition: Int, childPosition: Int): Any =
        topics[groupPosition].presentations[childPosition]

    override fun getGroupId(groupPosition: Int): Long = groupPosition.toLong()

    override fun getChildId(groupPosition: Int, childPosition: Int): Long = childPosition.toLong()

    override fun hasStableIds(): Boolean = true

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val groupView = LayoutInflater.from(context).inflate(R.layout.list_group, parent, false)
        val groupNameTextView: TextView = groupView.findViewById(R.id.groupNameTextView)
        groupNameTextView.text = topics[groupPosition].name
        return groupView
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val childView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        val lessonNameTextView: TextView = childView.findViewById(R.id.lessonNameTextView)
        lessonNameTextView.text = topics[groupPosition].presentations[childPosition].name
        return childView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean = true
}
